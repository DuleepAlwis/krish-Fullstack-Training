import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SheduledOrdersComponent } from './sheduled-orders.component';

describe('SheduledOrdersComponent', () => {
  let component: SheduledOrdersComponent;
  let fixture: ComponentFixture<SheduledOrdersComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SheduledOrdersComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SheduledOrdersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
