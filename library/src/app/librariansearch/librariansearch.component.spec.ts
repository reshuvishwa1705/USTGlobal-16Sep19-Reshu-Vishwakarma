import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LibrariansearchComponent } from './librariansearch.component';

describe('LibrariansearchComponent', () => {
  let component: LibrariansearchComponent;
  let fixture: ComponentFixture<LibrariansearchComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LibrariansearchComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LibrariansearchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
