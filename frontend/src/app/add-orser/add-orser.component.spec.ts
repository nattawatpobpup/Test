import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddOrserComponent } from './add-orser.component';

describe('AddOrserComponent', () => {
  let component: AddOrserComponent;
  let fixture: ComponentFixture<AddOrserComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddOrserComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddOrserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
