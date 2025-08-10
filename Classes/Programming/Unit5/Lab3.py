# This program will decode a message encrypted in Caesar Cypher, and write
# the message decrypted in shifts -1 to -96.

# Difficulties: I had a lot of trouble figuring out the right formula for
# the wrap-around portion of the Caesar code. At first, I tried have it as
# "newCharacterAscii = 95 + newCharacterAscii," but it didn't work very well
# with negative values. So, I decided to find the positive, absolute-value
# difference between 32 and newCharacterAscii, and subtract it from 126. I then
# realized the wrap-around shifts were still incorrect they didn't align, so
# I changed the equation to subtract from 127. Another thing I realized was that
# I couldn't use a single if statement to find the new Ascii character value,
# in the event that the original character had an Ascii value of 32. So, I used
# a while loop to find the difference between newCharacterAscii and 32.
# Other than that, I don't think I had much trouble.

# Sarah Gu

encodedMessage = open('SarahGu.txt', 'r')
text = encodedMessage.read().splitlines()

decodedMessages = open('decrypt.txt', 'w')

for shift in range (1, 97):
    decodedMessages.write('Shift -' + str(shift) + ': \t') # Print which shift
    # the text is decoded in (for convenience when determining how many shifts
    # were needed)
    for line in text:
        for letter in line: # Nexted loops to narrow the examination to each
        # character and to be able to perform separate tasks after each shift
            ascii = ord(letter)
            newCharacterAscii = ascii - shift
            # Determine the value of the new Ascii character if the shift needs
            # to "wrap around"
            while newCharacterAscii < 32: # While loop utilized just in case the
            # character has an Ascii value of 32
                difference = 32 - newCharacterAscii
                newCharacterAscii = 127 - difference
            newCharacter = chr(newCharacterAscii)
            decodedMessages.write(newCharacter) # Write each new decoded
            # character to decrypt.txt
    decodedMessages.write('\n' + '\n') # Separate each shift translation

encodedMessage.close()
decodedMessages.close()
