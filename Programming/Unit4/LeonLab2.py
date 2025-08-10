#Leon Zhou
#For this lab, you will generate an arithmetic quiz for the user. The program will generate random additions, subtractions, multiplication and division questions that the user has to solve.
#There should be four types of problems, addition, multiplication, subtraction, and division. They should all be single digit, except for division, where the  divident can be two digits.
#The same question should be asked until the user gets it right. The user can input q anytime to quit. If the user enters anything other than a q or an integer, the program asks the user
#to input a number and asks the user the question again.
#program part - using the functions that I have defined


import random
#defining functions part - each function will have its own little description
#defining operatorgen - generates operators for question, first part of question generating process
def operatorgen():
    whichoperator = random.randint(1,4)
    if whichoperator == 1:
        operator = " + "
    elif whichoperator == 2:
        operator = " - "
    elif whichoperator == 3:
        operator = " * "
    elif whichoperator == 4:
        operator = " / "
    return operator, whichoperator

#def number generator - generates numbers for arithmetic question, will be single digit for everything but division, division can have 2 digit dividend
def numbers(whichoperator):
    if whichoperator == 4:
        num1 = random.randint(1,99)
        num2 = random.randint(2,9)
        while num1 % num2 != 0:
            num1 = random.randint(1,99)
            num2 = random.randint(2,9)
    else:
        num1 = random.randint(1,9)
        num2 = random.randint(1,9)
    return num1, num2


#defining questioncreator - creates question using the numbers and operators previously generated
def questioncreator(num1, operator, num2):
    question = (str(num1) + operator + str(num2) + " = ")
    return question

#defining answertaker - function takes answer from user, sees if it should be converted to int or not, returns it
useranswer = "0"
def answertaker(useranswer):
    if useranswer[0] == "-":
        number = useranswer[1:]
        if number.isdigit() == True:
            useranswer = int(useranswer)
        else:
            useranswer = useranswer
    elif useranswer.isdigit() == True:
        useranswer = int(useranswer)
    else:
        useranswer = useranswer

    return useranswer
#defining answer generator - function that determines correct answer
def answergenerator(num1, num2):
    if whichoperator == 1:
        correctanswer = num1 + num2
    elif whichoperator == 2:
        correctanswer = num1 - num2
    elif whichoperator == 3:
        correctanswer = num1 * num2
    elif whichoperator == 4:
        correctanswer = num1 // num2
    return correctanswer
#defining right or wrong - comapring correct answer and user answer
def rightorwrong(correctanswer, useranswer):
    if correctanswer == useranswer:
        return True
    else:
        return False
#defining starttest - starts program by running first programs needed // doubles as question generator
def starttest():
    operator, whichoperator = operatorgen()
    num1, num2 = numbers(whichoperator)
    question = questioncreator(num1, operator, num2)
    return operator, whichoperator, question, num1, num2
#defining proceed - if user wishes to quit, it quits, if user inputs something other than int or q, user gets question again
def proceed(useranswer):
    if useranswer == "q":
        stillplaying = 0
    elif type(useranswer) == int:
        stillplaying = 1
    else:
        stillplaying = 2
    return stillplaying
stillplaying = proceed(useranswer)

#program part
stillplaying = 1
#while loop (only exit condition is if user wishes to quit)
while stillplaying != 0:
    operator, whichoperator, question, num1, num2 = starttest()
    useranswer = input(question)
    useranswer = answertaker(useranswer)
    correctanswer = answergenerator(num1, num2)
    trueorfalse = rightorwrong(correctanswer, useranswer)
    if trueorfalse == True:
        print("Correct!")
    else:
        while trueorfalse == False:
            print("Incorrect! Try Again!")
            useranswer = input(question)
            useranswer = answertaker(useranswer)
            trueorfalse = rightorwrong(correctanswer, useranswer)
