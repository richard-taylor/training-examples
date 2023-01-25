
class TransformCommon:
    def number_to_string(self, number):
        if (number % 3) == 0 and (number % 5) == 0:
            return "FizzBuzz"
        elif (number % 3) == 0:
            return "Fizz"
        elif (number % 5) == 0:
            return "Buzz"
        else:
            return str(number)

class TransformShort:
    def number_to_string(self, number):
        if number%15==0:
            return"FizzBuzz"
        if number%3==0:
            return"Fizz"
        if number%5==0:
            return"Buzz"
        return str(number)

class TransformExtracted:

    @staticmethod
    def is_multiple(number, factor):
        return number % factor == 0

    def number_to_string(self, number):
        THREE = "Fizz"
        FIVE = "Buzz"
        BOTH = "FizzBuzz"

        is3 = self.is_multiple(number, 3)
        is5 = self.is_multiple(number, 5)

        if is3 and is5:
            return BOTH
        if is3:
            return THREE
        if is5:
            return FIVE

        return str(number)

class TransformExtendable:
    def number_to_string(self, number):
        result = ""

        if number % 3 == 0:
            result += "Fizz"

        if number % 5 == 0:
            result += "Buzz"

        if len(result) == 0:
            result = str(number)

        return result

class TransformNested:
    def number_to_string(self, number):
        if number % 3 == 0:
            if number % 5 == 0:
                return "FizzBuzz"
            else:
                return "Fizz"

        elif number % 5 == 0:
            return "Buzz"

        else:
            return str(number)

class TransformMaxLikelihood:
    def number_to_string(self, number):
        if number % 15 != 0:
            if number % 5 != 0:
                if number % 3 != 0:
                    return str(number)
                else:
                    return "Fizz"
            else:
                return "Buzz"
        else:
            return "FizzBuzz"

class TransformPeriod15:

    FIZZ = "Fizz"
    BUZZ = "Buzz"
    N = None
    cache15 = [ FIZZ+BUZZ, N, N, FIZZ, N, BUZZ, FIZZ, N, N, FIZZ, BUZZ, N, FIZZ, N, N ]

    def number_to_string(self, number):
        result = self.cache15[number % 15]

        if result is None:
            return str(number)
        else:
            return result

class TransformPeriod15LowMemory:

    # 00 = number
    # 01 = Fizz
    # 10 = Buzz
    # 11 = FizzBuzz
    #
    BIT_SEQUENCE = int("0b000001001001000001100001000011", 2)

    def number_to_string(self, number):
        n = (self.BIT_SEQUENCE >> (2 * (number % 15))) & 3

        if n == 0:
            return str(number)
        if n == 1:
            return "Fizz"
        if n == 2:
            return "Buzz"
        
        return "FizzBuzz"

class TransformStatic:

    def __init__(self):
        transformer = TransformPeriod15()
        self.cache100 = [transformer.number_to_string(i + 1) for i in range(100)]
    
    def number_to_string(self, number):
        return self.cache100[number - 1]

class TransformEulerTotient:
    def number_to_string(self, number):

        # Euler's Totient Theorem can be used to show that (number ^ 4) % 15 must be in {0,1,6,10}

        n = (number * number * number * number) % 15

        if n == 1:
            return str(number)

        if n == 6:
            return "Fizz"

        if n == 10:
            return "Buzz"

        return "FizzBuzz"
