#include <Key.h>
#include <Keypad.h>
#include <Wire.h>

#include <LiquidCrystal_I2C.h>

char keys[4][4] = {{'1', '2', '3', '+'}, {'4', '5', '6', '-'}, {'7', '8', '9', '*'}, {'=', '0', '/', 'F'}};
byte Row[] = {3, 4, 5, 6};
byte Col[] = {7, 8, 9, 10};
Keypad myKeypad = Keypad(makeKeymap(keys), Row, Col, 4, 4);

int x, y;
char o = '0';
char e;
int result;
String firstNumber = "";
String secondNumber = "";
void setup()
{
    // put your setup code here, to run once:
    Serial.begin(9600);
}
void loop()
{
    // put your main code here, to run repeatedly:

    switch (myKeypad.getKey())
    {
    case '0':
    {
        Serial.print("0");
        if (o != '0')
        {
            String y = "0";
            secondNumber.concat(y);
        }
        else
        {
            String x = "0";
            firstNumber.concat(x);
        }
        break;
    }

    case '1':
    {
        Serial.print("1");
        if (o != '0')
        {
            String y = "1";
            secondNumber.concat(y);
        }
        else
        {
            String x = "1";
            firstNumber.concat(x);
        }

        break;
    }

    case '2':
    {
        Serial.print("2");
        if (o != '0')
        {
            String y = "2";
            secondNumber.concat(y);
        }
        else
        {
            String x = "2";
            firstNumber.concat(x);
        }

        break;
    }

    case '3':
    {
        Serial.print("3");
        if (o != '0')
        {
            String y = "2";
            secondNumber.concat(y);
        }
        else
        {
            String x = "2";
            firstNumber.concat(x);
        }

        break;
    }

    case '4':
    {
        Serial.print("4");
        if (o != '0')
        {
            String y = "4";
            secondNumber.concat(y);
        }
        else
        {
            String x = "4";
            firstNumber.concat(x);
        }

        break;
    }

    case '5':
    {
        Serial.print("5");
        if (o != '0')
        {
            String y = "5";
            secondNumber.concat(y);
        }
        else
        {
            String x = "5";
            firstNumber.concat(x);
        }
        break;
    }

    case '6':
    {
        Serial.print("6");
        if (o != '0')
        {
            String y = "6";
            secondNumber.concat(y);
        }
        else
        {
            String x = "6";
            firstNumber.concat(x);
        }
        break;
    }

    case '7':
    {
        Serial.print("7");
        if (o != '0')
        {
            String y = "7";
            secondNumber.concat(y);
        }
        else
        {
            String x = "7";
            firstNumber.concat(x);
        }

        break;
    }

    case '8':
    {
        Serial.print("8");
        if (o != '0')
        {
            String y = "8";
            secondNumber.concat(y);
        }
        else
        {
            String x = "8";
            firstNumber.concat(x);
        }

        break;
    }

    case '9':
    {
        Serial.print("9");
        if (o != '0')
        {
            String y = "9";
            secondNumber.concat(y);
        }
        else
        {
            String x = "9";
            firstNumber.concat(x);
        }

        break;
    }

    case '+':
    {
        Serial.print("+");
        o = '+';

        break;
    }

    case '-':
    {
        Serial.print("-");
        o = '-';

        break;
    }

    case '':
    {
        Serial.print("");
        o = '*';

        break;
    }

    case '/':
    {
        Serial.print("/");
        o = '/';

        break;
    }

    case '=':
    {
        Serial.print("=");
        e = '=';
        if (o == '+')
        {
            result = firstNumber.toInt() + secondNumber.toInt();
            Serial.println(result);
        }
        else if (o == '-')
        {
            result = firstNumber.toInt() - secondNumber.toInt();
            Serial.println(result);
        }
        else if (o == '*')
        {
            result = firstNumber.toInt() * secondNumber.toInt();
            Serial.println(result);
        }
        else if (o == '/')
        {
            result = firstNumber.toInt() / secondNumber.toInt();
            Serial.println(result);
        }

        firstNumber = "";
        secondNumber = "";
        o = '0';
        e = '0';
        result = '0';

        break;
    }

    case 'F':
    {
        Serial.print("F");

        break;
    }
    }
}