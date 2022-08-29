export interface SearchJObDTOInterface {
  position: string;

}
export class SearchJObDTO implements SearchJObDTOInterface {
  position: string;

  constructor(obj:SearchJObDTOInterface) {
    this.position = obj.position;
  }
}
