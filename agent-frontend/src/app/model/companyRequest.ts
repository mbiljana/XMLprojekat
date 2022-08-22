import { Company } from './company';

export interface CompanyRequestInterface {
  id?: number;
  company:Company;
  approved:boolean;

}
export class CompanyRequest implements CompanyRequestInterface {
  id?: number;
  company:Company;
  approved:boolean;

  constructor(obj: CompanyRequestInterface) {
      this.id = obj.id;
      this.company = obj.company;
      this.approved=obj.approved;

  }

}
