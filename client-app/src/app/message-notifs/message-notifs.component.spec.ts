import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MessageNotifsComponent } from './message-notifs.component';

describe('MessageNotifsComponent', () => {
  let component: MessageNotifsComponent;
  let fixture: ComponentFixture<MessageNotifsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MessageNotifsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MessageNotifsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
