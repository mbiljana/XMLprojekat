
export interface UserRequestInterface{
  id?:number;
  korisnicko: string;
  password: string;
  firstname: string;
  lastname: string;
  gender?:string;
  email:string;
  dateOfBirth?:string;
  mobile?:string;
  profilePicture:string;
}

export class UserRequest implements UserRequestInterface{
  id?:number;
  korisnicko: string;
  password: string;
  firstname: string;
  lastname: string;
  gender?:string;
  profilePicture:string;
  email:string;
  mobile?:string;
  dateOfBirth?:string;

  constructor(obj:UserRequestInterface) {
    this.id = obj.id;
    this.korisnicko = obj.korisnicko;
    this.password = obj.password;
    this.firstname = obj.firstname;
    this.lastname = obj.lastname;
    this.gender=obj.gender;
    this.profilePicture = obj.profilePicture;
    this.email = obj.email;
    this.dateOfBirth = obj.dateOfBirth;
    this.mobile = obj.mobile;
  }

}


