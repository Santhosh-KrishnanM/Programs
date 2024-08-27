def reverse_words(statement):
    words = statement.split()  # Split the statement into words
    reversed_words = []

    for word in words:
        if len(word) > 3:  # Reverse words with more than 3 letters
            reversed_words.append(word[::-1])
        else:
            reversed_words.append(word)  # Leave short words unchanged

    return ' '.join(reversed_words)  # Join the words back into a statement


# Read a set of statements
statements = [
    "The quick brown fox jumps over the lazy dog",
    "Hello world!",
    "A cat ran fast",
    "This is an example statement"
]

# Process each statement
for statement in statements:
    reversed_statement = reverse_words(statement)
    print(reversed_statement)
