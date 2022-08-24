import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewConnectionsBlockComponent } from './view-connections-block.component';

describe('ViewConnectionsComponent', () => {
  let component: ViewConnectionsBlockComponent;
  let fixture: ComponentFixture<ViewConnectionsBlockComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewConnectionsBlockComponent ]
    })
      .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewConnectionsBlockComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
