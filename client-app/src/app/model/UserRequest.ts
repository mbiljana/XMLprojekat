
export interface UserRequestInterface{
  id?:number;
  korisnicko: string;
  password: string;
  firstname: string;
  lastname: string;
  gender?:string;
}

export class UserRequest implements UserRequestInterface{
  id?:number;
  korisnicko: string;
  password: string;
  firstname: string;
  lastname: string;
  gender?:string;

  constructor(obj:UserRequestInterface) {
    this.id = obj.id;
    this.korisnicko = obj.korisnicko;
    this.password = obj.password;
    this.firstname = obj.firstname;
    this.lastname = obj.lastname;
    this.gender=obj.gender;
  }

}


