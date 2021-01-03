import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MatchByDateComponent } from './match-by-date.component';

describe('MatchByDateComponent', () => {
  let component: MatchByDateComponent;
  let fixture: ComponentFixture<MatchByDateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MatchByDateComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MatchByDateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
