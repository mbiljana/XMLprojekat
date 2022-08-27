import {User} from "./user";
import {Message} from "./message";

export interface MessageNotifInterface{
  id:number;
  Date:Date;
  message: Message;
  user:string;
  post:boolean;
}
export class MessageNotif implements MessageNotifInterface{
  id:number;
  Date:Date;
  message:Message;
  user:string;
  post:boolean;

  constructor(obj:MessageNotifInterface) {
    this.id = obj.id;
    this.Date = obj.Date;
    this.message = obj.message;
    this.user = obj.user;
    this.post = obj.post;
  }
}
