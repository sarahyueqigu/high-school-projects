# This program will calculate the login name of a student on campus by asking the
# use for their first and last name and studnet ID. The login name will be the
# first three letters of their first and last name, and the last three letters of their
# student ID.
# Sarah Gu

firstName = input('Enter your first name: ').lower()
lastName = input('Enter your last name: ').lower()
ID = input('Enter your student ID: ').lower()

loginUsername = firstName[0:3] + lastName[0:3] + ID[-3:]

print(loginUsername)
