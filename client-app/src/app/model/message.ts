export interface MessageInterface{
  id?:number;
  senderUsername:string;
  recieverUsername:string;
  message:string;
  sentDate: Date;
}
export class Message implements MessageInterface{
  id?:number;
  senderUsername:string;
  recieverUsername:string;
  message:string;
  sentDate: Date;

  constructor(obj:MessageInterface) {
    this.id = obj.id;
    this.senderUsername = obj.senderUsername;
    this.recieverUsername = obj.recieverUsername;
    this.message = obj.message;
    this.sentDate = obj.sentDate;
  }
}
