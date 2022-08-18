
export interface UserInterface {
    id: number ;
    firstName: string;
    lastName: string;
    username: string;
    password: string;
    email: string;
    mobile: string;
    profilePicture?:string;
    gender?:string;
    role: string;
    firstLogin: boolean;
}
export class User implements UserInterface {
  id: number ;
  firstName: string;
  lastName: string;
  username: string;
  password: string;
  email: string;
  mobile: string;
  profilePicture?:string;
  gender?:string;
  role: string;
  firstLogin: boolean;

  constructor(obj: UserInterface) {
      this.id = obj.id;
      this.firstName = obj.firstName;
      this.lastName = obj.lastName;
      this.username = obj.username;
      this.password = obj.password;
      this.email = obj.email;
      this.mobile = obj.mobile;
      this.profilePicture=obj.profilePicture;
      this.gender=obj.gender;
      this.role = obj.role;
      this.firstLogin = obj.firstLogin;
  }


}
