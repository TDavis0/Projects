"""
Author: Kyle Atchley, Long Thai
"""
import FacialRecognition, Vault

database = Vault.Vault()
face_database = FacialRecognition.Facial_Model()

class GUI_Functions():
    GrantAccess = False

    def create_new_user(self, name, rfid) -> bool:
        if(database.exist_name(name) and database.verify_rfid(name, rfid)):
            return False
        else:
            new_user = database.new_user()
            new_user.set_name(name)
            new_user.set_hash(rfid)
            face_database.create_new_face(new_user.get_name())
            return True

    def existing_user(self, username, rfid):
        name = username
        if(database.exist_name(name) == False):
            GUI_Functions.GrantAccess = False
            return
        user = database.get_user(name)
        password = rfid
        check_rfid = database.verify_rfid(user,password)
        if(check_rfid):
            if(face_database.recognize(user.get_name()) == True):
                GUI_Functions.GrantAccess = True
                return
            else:
                GUI_Functions.GrantAccess = False
                return
        else:
            GUI_Functions.GrantAccess = False
            return