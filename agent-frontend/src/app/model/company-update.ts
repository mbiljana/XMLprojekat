import {Address} from "./address";

export interface UpdateCompanyInterface {
  id: number ;
  name: string;
  description: string;
  address: Address;
  username: string;
  email: string;
  //profilePicture?:string;
  mobile: string;
}
export class UpdateCompany implements UpdateCompanyInterface {
  id: number ;
  name: string;
  description: string;
  address: Address;
  username: string;
  email: string;
  //profilePicture?:string;
  mobile: string;

  constructor(obj: UpdateCompanyInterface) {
    this.id = obj.id;
    this.name = obj.name;
    this.description = obj.description;
    this.address = obj.address;
    this.username = obj.username;
    this.email = obj.email;
    this.mobile = obj.mobile;
    //this.profilePicture=obj.profilePicture;
  }


}
