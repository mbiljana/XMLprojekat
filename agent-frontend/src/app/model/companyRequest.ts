import { Company } from './company';

export interface CompanyRequestInterface {
  id?: number;
  company:Company;


}
export class CompanyRequest implements CompanyRequestInterface {
  id?: number;
  company:Company;

  constructor(obj: CompanyRequestInterface) {
      this.id = obj.id;
      this.company = obj.company;


  }

}
