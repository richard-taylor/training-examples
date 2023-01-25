
class Printer:

    def __init__(self, quiet = False):
        self.lines = []
        self.quiet = quiet

    def print(self, line):
        if not self.quiet:
            print(line)
        self.lines.append(str(line))

    def line_count(self):
        return len(self.lines)

    def line_printed(self, line_number):
        return self.lines[line_number - 1]

    def last_line_printed(self):
        return self.lines[-1]
