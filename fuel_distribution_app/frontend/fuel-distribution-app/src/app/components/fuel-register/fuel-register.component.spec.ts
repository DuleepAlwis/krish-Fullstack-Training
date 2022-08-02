import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FuelRegisterComponent } from './fuel-register.component';

describe('FuelRegisterComponent', () => {
  let component: FuelRegisterComponent;
  let fixture: ComponentFixture<FuelRegisterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FuelRegisterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FuelRegisterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
