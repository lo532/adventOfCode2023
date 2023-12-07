input = list()
values = list()

with open('input.txt', 'r') as f:
    for line in f:
        input.append(line.rstrip())


calibration_sum = 0


def get_calibration_value(line):
  first_digit = None
  last_digit = None

  num_to_words = {
        "zero": "0",
        "one": "1",
        "two": "2",
        "three": "3",
        "four": "4",
        "five": "5",
        "six": "6",
        "seven": "7",
        "eight": "8",
        "nine": "9",
    }


  for index, char in enumerate(line):
    if char.isdigit():
      if not first_digit:
        first_digit = char
      last_digit = char
    else:
      for num_word, num in num_to_words.items():
        num_word_length = len(num_word)
        if index+num_word_length <= len(line):
          if line[index:index+num_word_length] == num_word:
            if not first_digit:
              first_digit = num
            last_digit = num
       
  return int(first_digit + last_digit)

for line in input:
  calibration_sum += get_calibration_value(line)
print(calibration_sum)
