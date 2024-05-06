#This program is a household account book application.
#It offers four options: viewing current finances, recording income, recording expenses, or exiting the program.
#Choosing to view current finances displays the user's current balance.
#Opting to record income or expenses prompts the application to log the amounts in an external file.
#This tool aims to enable users to efficiently manage their financial situation.


#Import the OS module, which provides functions for interacting with the operating system.
#This module allows us to create, open, edit, and delete files.
import os

#Assigning a log file to a variable
LOG_FILE = 'finances.log'

#This function is designed to log transactions and amounts in an external file.
def record(transaction, amount):
    with open(LOG_FILE, 'a') as file:
        file.write(f"{transaction},{amount}\n")

#This function is developed to display the user's current balance.
def show():
    #This condition checks whether the log file exists.
    if not os.path.isfile(LOG_FILE):
        print("No financial data found. Your balance is $0.")
        return
    #Setting the balance to zero to restart the tracking of the balance.
    balance = 0

    #This program will calculate the balance.
    with open(LOG_FILE, 'r') as file:
        #This loop reads each row
        for line in file:
            #Splits the row into transaction and amount.
            transaction, amount = line.split(',')
            amount = float(amount)
            #Adds or subtracts depending on whether it's "Income" or "Expenses".
            if transaction == 'Income':
                balance += amount
            elif transaction == 'Expenses':
                balance -= amount
    #Displays the current balance in USD.
    print(f"Current balance: ${balance}")


#The main function serves as the point of entry.
#This function displays the menu and passes the transaction name and amount to the corresponding function.
def main():
    #This function continues until the user exits from the console.
    while True:
        #It displays the main menu and accepts input from the user.
        print('Main menu:')
        print('1. Show current finances')
        print('2. Record income')
        print('3. Record expense')
        print('4. Exit')

        answer = input("Choose an option: ")

        #If the user chooses option 1, it shows the current balance.
        if answer == '1':
            show()

        #Receive an input for the income amount and pass the transaction name and the amount to the corresponding function.
        elif answer == '2':
            amount_input = input("Enter the income amount: ")
            #Check whether the input is an integer or a floating-point number.
            try:
                amount = float(amount_input)
                #Check if the input is greater than 0 and then call the corresponding function.
                if  amount > 0:
                    record('Income', amount)
                else:
                    print('Invalid value. Please try again.')
            except ValueError:
                print('Invalid value. Please try again.')
        #Receive an input for the expenses amount and pass the transaction name and the amount to the corresponding function.
        elif answer == '3':
            amount_input = input("Enter the expense amount: ")
            #Check whether the input is an integer or a floating-point number.
            try:
                amount = float(amount_input)
                #Check if the input is greater than 0 and then call the corresponding function.
                if  amount > 0:
                    record('Expenses', amount)
                else:
                    print('Invalid value. Please try again.')
            except ValueError:
                print('Invalid value. Please try again.')
        #Exit from the console
        elif answer == '4':
            break
        else:
            print('Invalid option. Please try again.')



if __name__ == "__main__":
    main()
