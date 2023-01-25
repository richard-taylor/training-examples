import unittest

from  fizzbuzz import FizzBuzz
from  printers import Printer

class FizzBuzzTests(unittest.TestCase):

    def test_play(self):
        printer = Printer(quiet = True)
        fizz_buzz = FizzBuzz(printer)

        self.assertEqual(0, printer.line_count())

        fizz_buzz.play()

        self.assertEqual(100, printer.line_count())

        self.assertEqual("1", printer.line_printed(1))
        self.assertEqual("2", printer.line_printed(2))

        self.assertEqual("Fizz", printer.line_printed(3))
        self.assertEqual("Fizz", printer.line_printed(6))

        self.assertEqual("Buzz", printer.line_printed(5))
        self.assertEqual("Buzz", printer.line_printed(10))

        self.assertEqual("FizzBuzz", printer.line_printed(15))
        self.assertEqual("FizzBuzz", printer.line_printed(30))

    def test_replay(self):
        printer = Printer(quiet = True)
        fizz_buzz = FizzBuzz(printer)

        expected_lines = 0

        for trial in range(10):

            fizz_buzz.play()

            expected_lines += 100
            self.assertEqual(expected_lines, printer.line_count())

            self.assertEqual("1", printer.line_printed( 1 + 100 * trial ))
            self.assertEqual("Fizz", printer.line_printed( 3 + 100 * trial ))
            self.assertEqual("Buzz", printer.line_printed( 5 + 100 * trial ))
            self.assertEqual("FizzBuzz", printer.line_printed( 15 + 100 * trial ))
