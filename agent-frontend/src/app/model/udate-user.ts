export interface UpdateUserInterface {
  id: number ;
  firstName: string;
  lastName: string;
  username: string;
  password: string;
  email: string;
  mobile: string;
  profilePicture?:string;
}
export class UpdateUser implements UpdateUserInterface {
  id: number ;
  firstName: string;
  lastName: string;
  username: string;
  password: string;
  email: string;
  mobile: string;
  profilePicture?:string;

  constructor(obj: UpdateUserInterface) {
    this.id = obj.id;
    this.firstName = obj.firstName;
    this.lastName = obj.lastName;
    this.username = obj.username;
    this.password = obj.password;
    this.email = obj.email;
    this.mobile = obj.mobile;
    this.profilePicture=obj.profilePicture;
  }


}
