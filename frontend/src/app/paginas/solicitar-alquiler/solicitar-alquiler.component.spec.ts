import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SolicitarAlquilerComponent } from './solicitar-alquiler.component';

describe('SolicitarAlquilerComponent', () => {
  let component: SolicitarAlquilerComponent;
  let fixture: ComponentFixture<SolicitarAlquilerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SolicitarAlquilerComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(SolicitarAlquilerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
