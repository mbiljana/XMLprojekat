
export interface CompanyInterface {
  id?:number;
  name: string;
  username: string;
  password: string;
  email: string;
  mobile: string;
  profilePicture?:string;

}
export class Company implements CompanyInterface {
  id?:number;
  name: string;
  username: string;
  password: string;
  email: string;
  mobile: string;
  profilePicture?:string;

  constructor(obj: CompanyInterface) {
      this.id=obj.id;
      this.name=obj.name;
      this.username = obj.username
      this.password = obj.password;
      this.email = obj.email;
      this.mobile = obj.mobile;
      this.profilePicture=obj.profilePicture;
  }
}
