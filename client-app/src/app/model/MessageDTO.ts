export interface MessageDTOInterface{
  senderUsername:string;
  recieverUsername:string;
  message:string;
}
export class MessageDTO implements MessageDTOInterface{
  senderUsername:string;
  recieverUsername:string;
  message:string;

  constructor(obj:MessageDTOInterface) {
    this.senderUsername = obj.senderUsername;
    this.recieverUsername = obj.recieverUsername;
    this.message = obj.message;
  }
}
