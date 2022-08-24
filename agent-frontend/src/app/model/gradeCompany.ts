import { Company } from './company';

export interface GradeCompanyInterface {
  id?: number;
  company:Company;
  grade:number;

}
export class GradeCompany implements GradeCompanyInterface {
  id?: number;
  company:Company;
  grade:number;

  constructor(obj: GradeCompanyInterface) {
      this.id = obj.id;
      this.company = obj.company;
      this.grade=obj.grade;

  }

}
