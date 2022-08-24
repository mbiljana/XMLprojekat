import { ProfileType } from './profileType';
export interface UserInterface {
    id: number ;
    firstName: string;
    lastName: string;
    username: string;
    password: string;
    email: string;
    mobile: string;
    dateOfBirth?: string;
    profilePicture?:string;
    gender?:string;
    profileType:ProfileType;
    role: string;
    firstLogin: boolean;
    following:string[];
    followRequests:string[];
    blocked?:string[];
}
export class User implements UserInterface {
  id: number ;
  firstName: string;
  lastName: string;
  username: string;
  password: string;
  email: string;
  mobile: string;
  dateOfBirth?: string;
  profilePicture?:string;
  gender?:string;
  profileType:ProfileType;
  role: string;
  firstLogin: boolean;
  following:string[];
  followRequests:string[];
  blocked?:string[];

  constructor(obj: UserInterface) {
      this.id = obj.id;
      this.firstName = obj.firstName;
      this.lastName = obj.lastName;
      this.username = obj.username;
      this.password = obj.password;
      this.email = obj.email;
      this.mobile = obj.mobile;
      this.dateOfBirth = obj.dateOfBirth;
      this.profilePicture=obj.profilePicture;
      this.gender=obj.gender;
      this.profileType=obj.profileType;
      this.role = obj.role;
      this.firstLogin = obj.firstLogin;
      this.following = obj.following;
      this.followRequests = obj.followRequests;
      this.blocked = obj.blocked;
  }


}
