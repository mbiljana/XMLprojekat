import { Address } from "./address";
import { User } from "./user";

export interface CompanyInterface {
	id:number;
	name:string;
	description:string;
	address:Address;
	username:string;
	email:string;
	mobile:string;
	profilePicture:string;
	owner:User;
}
export class Company implements CompanyInterface {
	id:number;
	name:string;
	description:string;
	address:Address;
	username:string;
	email:string;
	mobile:string;
	profilePicture:string;
	owner:User;


constructor(obj: CompanyInterface) {
    this.id = obj.id;
    this.name = obj.name;
    this.description = obj.description;
    this.address = obj.address;
    this.username = obj.username;
    this.email = obj.email;
    this.mobile = obj.mobile;
    this.profilePicture=obj.profilePicture;
    this.owner=obj.owner;
}


}
