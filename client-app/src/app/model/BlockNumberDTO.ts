export interface BlockNumberDTOInterface {
  blockNum:number;

}
export class BlockNumberDTO implements BlockNumberDTOInterface {
  blockNum:number;

  constructor(obj: BlockNumberDTOInterface) {
    this.blockNum = obj.blockNum;
  }
}
