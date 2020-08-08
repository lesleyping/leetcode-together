class Solution {
public:
    bool isNumeric(char* string)
    {
        if (string == nullptr)
            return false;
        bool numeric = scanInteger(&string);
        if (*string == '.'){
            ++string;
            numeric = scanUnsignedInteget(&string) || numeric;
        }
        if (*string == 'E' || *string == 'e'){
            ++string;
            numeric = numeric && scanInteger(&string);
        }
        return numeric && *string == '\0';
    }
    bool scanUnsignedInteget(char** str){
        char* before = *str;
        while (**str != '\0' && **str >= '0' && **str <= '9'){
            ++(*str);
        }
        return *str > before;
    }
    
    bool scanInteger(char** string){
        if (**string == '+' || **string == '-'){
            ++(*string);
        }
        return scanUnsignedInteget(string);
    }
};