import transformers

# Play the fizz buzz game.
#
# For all the numbers from 1 to 100, either
#
# Print the number
# Print "Fizz" if the number is a multiple of 3
# Print "Buzz" if the number is a multiple of 5
# Print "FizzBuzz" if the number is a multiple of 3 and 5.

class FizzBuzz:

    def __init__(self, printer, transformer = None):
        self.printer = printer;
        if transformer is None:
            self.transformer = transformers.TransformCommon()
        else:
            self.transformer = transformer

    def play(self):
        for i in range(1, 101):
            self.printer.print(self.transformer.number_to_string(i))
