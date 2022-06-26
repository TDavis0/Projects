"""
Author: Kyle Atchley
"""
import GUI_Fx
from tkinter import *

from cv2 import destroyWindow

HEIGHT = 300
WIDTH = 600

root = Tk()
root.title("2FA Security App")

canvas = Canvas(root, height=HEIGHT, width=WIDTH)
canvas.pack()


guifuncs = GUI_Fx.GUI_Functions()

class Window:
    def __init__(self, root):
        self.Main_menu(root)

    def ExistingUserFrame(self):
        frame = Frame(root)
        frame.place(relheight=1, relwidth=1)

        label = Label(frame, font=40, text="Enter the name of the existing user")
        label.place(relx=0.2, rely=0.1, relheight=0.2, relwidth=0.6)

        entry = Entry(frame, font=20, textvariable=self.userName)
        entry.place(relx=0.1, rely=0.4, relheight=0.15, relwidth=0.5)

        buttonNext = Button(frame, text="Submit", command=lambda:self.rfidFrameExisting())
        buttonNext.place(relx=0.6, rely=0.75, relheight=0.1, relwidth=0.2)

        buttonBack = Button(frame, text="Back", command=lambda:self.Main_menu(root))
        buttonBack.place(relx=0.2, rely=0.75, relheight=0.1, relwidth=0.2)

    def rfidFrameExisting(self):
        user = self.userName.get()

        frame = Frame(root)
        frame.place(relheight=1, relwidth=1)

        label = Label(frame, font=40, text="Enter the rfid for " + user)
        label.place(relx=0.2, rely=0.1, relheight=0.2, relwidth=0.6)

        entry = Entry(frame, font=20, show="*", textvariable=self.rfid)
        entry.place(relx=0.1, rely=0.4, relheight=0.15, relwidth=0.5)

        buttonNext = Button(frame, text = "Submit", command=lambda:self.AttemptAccess(self.userName.get(), self.rfid.get()))
        buttonNext.place(relx=0.6, rely=0.75, relheight=0.1, relwidth=0.2)

        buttonBack = Button(frame, text="Back", command=lambda:self.Main_menu(root))
        buttonBack.place(relx=0.2, rely=0.75, relheight=0.1, relwidth=0.2)

    def NewUserFrame(self):
        frame = Frame(root)
        frame.place(relheight=1, relwidth=1)

        label = Label(frame, font=40, text="Enter the name of the new user")
        label.place(relx=0.2, rely=0.1, relheight=0.2, relwidth=0.6)

        entry = Entry(frame, font=20, textvariable=self.userName)
        entry.place(relx=0.1, rely=0.4, relheight=0.15, relwidth=0.5)

        buttonNext = Button(frame, text="Submit", command=lambda:self.rfidFrameNew())
        buttonNext.place(relx=0.6, rely=0.75, relheight=0.1, relwidth=0.2)

        buttonBack = Button(frame, text="Back", command=lambda:self.Main_menu(root))
        buttonBack.place(relx=0.2, rely=0.75, relheight=0.1, relwidth=0.2)

    def rfidFrameNew(self):
        user = self.userName.get()

        frame = Frame(root)
        frame.place(relheight=1, relwidth=1)

        label = Label(frame, font=40, text="Enter the rfid for " + user)
        label.place(relx=0.2, rely=0.1, relheight=0.2, relwidth=0.6)

        entry = Entry(frame, font=20, show="*", textvariable=self.rfid)
        entry.place(relx=0.1, rely=0.4, relheight=0.15, relwidth=0.5)

        buttonNext = Button(frame, text = "Next", command=lambda:self.UserCreation(self.userName.get(), self.rfid.get()))
        buttonNext.place(relx=0.6, rely=0.75, relheight=0.1, relwidth=0.2)

        buttonBack = Button(frame, text="Back", command=lambda:self.Main_menu(root))
        buttonBack.place(relx=0.2, rely=0.75, relheight=0.1, relwidth=0.2)

    def AttemptAccess(self, name, passw):
        guifuncs.existing_user(name, passw)
        if(guifuncs.GrantAccess):
            self.AccessGranted(root)
        else:
            top = Toplevel(root)
            top.geometry("600x300")
            top.title("Access Denied")

            label = Label(top, font=20, text="Invalid face, username, or rfid.")
            label.place(relx=0.2, rely=0.1, relheight=0.2, relwidth=0.6)

            button = Button(top, text = "Main Menu", command=lambda:[self.Main_menu(root), top.destroy])
            button.place(relx=0.4, rely=0.7, relheight=0.1, relwidth=0.2)

    def AccessGranted(self,master):
        frame = Frame(root)
        frame.place(relheight=1, relwidth=1)

        label = Label(frame, font=60, text="Access granted, welcome " + self.userName.get())
        label.place(relx=0.1, rely=0.1, relheight=0.2, relwidth=0.8)
        button = Button(frame, text = "Main Menu", command=lambda:self.Main_menu(root))
        button.place(relx=0.4, rely=0.7, relheight=0.1, relwidth=0.2)

    def UserCreation(self, name, passw):
        frame = Frame(root)
        frame.place(relheight=1, relwidth=1)

        userMade = guifuncs.create_new_user(name, passw)

        if(userMade):
            top = Toplevel(root)
            top.geometry("600x300")
            top.title("Success")

            label = Label(top, font=20, text="User has been created!")
            label.place(relx=0.2, rely=0.2, relheight=0.2, relwidth=0.6)

            button = Button(top, text = "Main Menu",command=lambda:[self.Main_menu(root), top.destroy])
            button.place(relx=0.4, rely=0.7, relheight=0.1, relwidth=0.2)
        else:
            top = Toplevel(root)
            top.geometry("600x300")
            top.title("Error")

            label = Label(top, font=20, text="User already exists!")
            label.place(relx=0.2, rely=0.2, relheight=0.2, relwidth=0.6)

            button = Button(top, text = "Main Menu",command=lambda:[self.Main_menu(root), top.destroy])
            button.place(relx=0.4, rely=0.7, relheight=0.1, relwidth=0.2)

    def Main_menu(self, root):
        self.userName = StringVar()
        self.rfid = StringVar()
        frame = Frame(root)
        frame.place(relheight=1, relwidth=1)

        buttonExisting = Button(frame, text="Authenticate existing user", bg='gray', command=self.ExistingUserFrame)
        buttonExisting.place(relx=0.0667, rely=0.3, relheight=0.25, relwidth=0.4)

        buttonNewUserFrame = Button(frame, text="Create a new user", bg='gray', command=self.NewUserFrame)
        buttonNewUserFrame.place(relx=0.5333, rely=0.3, relheight=0.25, relwidth=0.4)

        buttonExit = Button(frame, text="Exit", bg='gray', command=self.Close)
        buttonExit.place(relx=0.4, rely=0.7, relheight=0.1, relwidth=0.2)


    def Close(self):
        root.destroy()

def run():
    m = Window(root)
    root.mainloop()