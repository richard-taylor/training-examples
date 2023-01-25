import unittest

from printers import Printer

class PrinterTests(unittest.TestCase):

    def test_constructor(self):
        printer = Printer()
        self.assertEqual(0, printer.line_count())

        quiet_printer = Printer(quiet = True)
        self.assertEqual(0, quiet_printer.line_count())

    def test_print_string(self):
        printer = Printer(quiet = True)
        printer.print("testing 123")
        self.assertEqual(1, printer.line_count())
        self.assertEqual("testing 123", printer.last_line_printed())

    def test_print_number(self):
        printer = Printer(quiet = True)
        printer.print(1234)
        self.assertEqual(1, printer.line_count())
        self.assertEqual("1234", printer.last_line_printed())

    def test_counter(self):
        printer = Printer(quiet = True)
        printer.print(100)
        printer.print(200)
        printer.print(300)
        printer.print(400)
        self.assertEqual(4, printer.line_count())
        self.assertEqual("100", printer.line_printed(1))
        self.assertEqual("200", printer.line_printed(2))
        self.assertEqual("300", printer.line_printed(3))
        self.assertEqual("400", printer.line_printed(4))
        self.assertEqual("400", printer.last_line_printed())
