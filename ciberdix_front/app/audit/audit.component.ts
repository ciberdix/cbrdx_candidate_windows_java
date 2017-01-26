import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

import { AlertService, AuditService } from '../_services/index';

@Component({
    moduleId: module.id,
    templateUrl: 'audit.component.html'
})

export class AuditComponent implements OnInit {
    audits: any[] = [];

    constructor(private auditService: AuditService){

    }

    ngOnInit() {
        // reset login status
        this.loadAllAudits();
    }

    private loadAllAudits() {
        this.auditService.getAllAudits().subscribe(audits => { this.audits = audits; });
    }

}
