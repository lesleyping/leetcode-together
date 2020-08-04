class Solution1 {
public:
    int Fibonacci(int n) {
        int fibminus1 = 1;
        int fibminus2 = 0;
        int fib;
        if(n <= 1)return n;
        for(int i = 2; i <= n; i++){
            fib = fibminus1 + fibminus2;
            fibminus2 = fibminus1;
            fibminus1 = fib;
        }
        return fib;
    }
};
// Solution2 - mine
struct Matrix2by2{
    Matrix2by2(int m_00 = 0, int m_01 = 0, int m_10= 0, int m_11 = 0):m00(m_00),m01(m_01),m10(m_10),m11(m_11)
    {
        
    }
    int m00;
    int m01;
    int m10;
    int m11;
};
Matrix2by2 Multiply(Matrix2by2& matrix1, Matrix2by2& matrix2){
    return Matrix2by2(
        matrix1.m00 * matrix2.m00 + matrix1.m01 * matrix2.m10,
        matrix1.m00 * matrix2.m01 + matrix1.m01 * matrix2.m11,
        matrix1.m10 * matrix2.m00 + matrix1.m11 * matrix2.m10,
        matrix1.m10 * matrix2.m01 + matrix1.m11 * matrix2.m11);
}
Matrix2by2 PowerMatrix(int n){
    Matrix2by2 mat;
    if(n == 1){
        mat = Matrix2by2(1, 1, 1, 0);
    }
    else if(n % 2 == 0){
        mat = PowerMatrix(n/2);
        mat = Multiply(mat, mat);
    }
    else if(n % 2 == 1){
        Matrix2by2 tmp = Matrix2by2(1,1,1,0);
        mat = PowerMatrix(n/2);
        mat = Multiply(mat, mat);
        mat = Multiply(mat, tmp);
    }
    return mat;
}
class Solution2 {
public:
    int Fibonacci(int n) {
        int result[] = {0, 1};
        if(n < 2)
            return result[n];
        Matrix2by2 res = PowerMatrix(n-1);
        return res.m00;
    }
};

//Solution2 - 网站源码
#include <cassert>
#include<iostream>
using namespace std;
struct Matrix2By2
{
	Matrix2By2(long long m00 = 0,long long m01 = 0,long long m10 = 0,long long m11 = 0):m_00(m00), m_01(m01), m_10(m10), m_11(m11)
	{
	}
	long long m_00;
	long long m_01;
	long long m_10;
	long long m_11;
};
Matrix2By2 MatrixMultiply
(
	const Matrix2By2& matrix1,
	const Matrix2By2& matrix2
)
{
	return Matrix2By2(
		matrix1.m_00 * matrix2.m_00 + matrix1.m_01 * matrix2.m_10,
		matrix1.m_00 * matrix2.m_01 + matrix1.m_01 * matrix2.m_11,
		matrix1.m_10 * matrix2.m_00 + matrix1.m_11 * matrix2.m_10,
		matrix1.m_10 * matrix2.m_01 + matrix1.m_11 * matrix2.m_11);
}
Matrix2By2 MatrixPower(unsigned int n)
{
	assert(n > 0);
	Matrix2By2 matrix;
	if (n == 1)
	{
		matrix = Matrix2By2(1, 1, 1, 0);
	}
	else if (n % 2 == 0)
	{
		matrix = MatrixPower(n / 2);
		matrix = MatrixMultiply(matrix, matrix);
	}
	else if (n % 2 == 1)
	{
		matrix = MatrixPower((n - 1) / 2);
		matrix = MatrixMultiply(matrix, matrix);
		matrix = MatrixMultiply(matrix, Matrix2By2(1, 1, 1, 0));
	}
	return matrix;
}
long long Fibonacci_Solution3(unsigned int n)
{
	int result[2] = { 0, 1 };
	if (n < 2)
		return result[n];
	Matrix2By2 PowerNMinus2 = MatrixPower(n - 1);
	return PowerNMinus2.m_00;
}
// ====================测试代码====================
void Test(int n, int expected)
{
	
	if (Fibonacci_Solution3(n) == expected)
		printf("Test for %d in solution3 passed.\n", n);
	else
		printf("Test for %d in solution3 failed.\n", n);
}
int main(int argc, char* argv[])
{
	Test(0, 0);
	Test(1, 1);
	Test(2, 1);
	Test(3, 2);
	Test(4, 3);
	Test(5, 5);
	Test(6, 8);
	Test(7, 13);
	Test(8, 21);
	Test(9, 34);
	Test(10, 55);
	Test(40, 102334155);
	return 0;
}