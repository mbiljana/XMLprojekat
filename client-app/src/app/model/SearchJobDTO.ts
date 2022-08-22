export interface SearchJObDTOInterface {
  title: string;

}
export class SearchJObDTO implements SearchJObDTOInterface {
  title: string;

  constructor(obj:SearchJObDTOInterface) {
    this.title = obj.title;
  }
}
