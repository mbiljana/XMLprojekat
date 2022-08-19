export interface ConnectionsNumberDTOInterface {
  connectionsNum:number;

}
export class ConnectionsNumberDTO implements ConnectionsNumberDTOInterface {
  connectionsNum:number;

  constructor(obj: ConnectionsNumberDTOInterface) {
    this.connectionsNum = obj.connectionsNum;
  }
}
