#import the code
#put all ascii characters from 32 to 126 in list
#make list to put new message in
#set a counter at 1
#repeat 96 times: look at every character, convert to ascii number, subtract counter, convert back to character, put in list

#DOCUMENTATION OR SMTH
# function to convert file to ascii - check
# function to shift ascii - check
# another function used with above function to do the wrap-around thing - check
# function to convert ascii back to characters - check
# function to append to decrypt file
# main program has for loop to run thru every possibility


def convert_to_ascii(string): #WORKS HALLELUJAH
    ASCIINums = []
    for i in string: #for every character in the string (file), convert to the ascii number
        asc = ord(i)
        ASCIINums.append(asc) #change str(asc) to asc

    return ASCIINums #return the list
def wrap_around(shiftedASCII):
    #borders are 32 and 126; if a number goes below 32 or above 126 it wraps around
    shiftedASCII = 126 - (int(shiftedASCII) + 96) #if the number is below 32 (used in shift function) then add numbers to wrap around
    return shiftedASCII #return the new value

def shift(num, asc): #complete
    shiftedASCII = []
    for i in asc: #for every item in the ascii number list, subtract the shift number from that number for a new number
        newNum = i - num
        if i < 32: #in the event that the new number is too small, use the wrap around function to make it within the right range
            newNum = wrap_around(i)
        shiftedASCII.append(newNum) #append new value to shiftedASCII list
    return shiftedASCII #return list of shifted values

def convert_to_char(string): #same as convert_to_ascii() but reversed; converts back to characters from ASCII
    newChars = []
    for i in string:
        char = chr(i) #ask if its ok to not have the rest of the code if i found the correct one already
        newChars.append(char)
    return newChars #return the new characters in a list
def main():
    fo = open("KeiraChen.txt", encoding = "utf8")

    for line in fo:
        line.rstrip()
        asc = convert_to_ascii(line)
        for i in range(26):
            shiftedAsc = shift(i, asc)
            input((''.join(convert_to_char(shiftedAsc))))

    fo.close()

main()
