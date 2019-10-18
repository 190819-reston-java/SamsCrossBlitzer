import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { JSPComponent } from './jsp.component';

describe('JSPComponent', () => {
  let component: JSPComponent;
  let fixture: ComponentFixture<JSPComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ JSPComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(JSPComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
