
export interface UserRequestInterface{
  id?:number;
  korisnicko: string;
  password: string;
  firstName: string;
  lastName: string;
  gender?:string;
  email:string;
  mobile:string;
}

export class UserRequest implements UserRequestInterface{
  id?:number;
  korisnicko: string;
  password: string;
  firstName: string;
  lastName: string;
  gender?:string;
  email:string;
  mobile:string;

  constructor(obj:UserRequestInterface) {
    this.id = obj.id;
    this.korisnicko = obj.korisnicko;
    this.password = obj.password;
    this.firstName = obj.firstName;
    this.lastName = obj.lastName;
    this.gender=obj.gender;
    this.email = obj.email;
    this.mobile = obj.mobile;
  }

}


