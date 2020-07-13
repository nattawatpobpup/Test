import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FixCarComponent } from './fix-car.component';

describe('FixCarComponent', () => {
  let component: FixCarComponent;
  let fixture: ComponentFixture<FixCarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FixCarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FixCarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
