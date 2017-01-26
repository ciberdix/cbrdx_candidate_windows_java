"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var core_1 = require("@angular/core");
var index_1 = require("../_services/index");
var AuditComponent = (function () {
    function AuditComponent(auditService) {
        this.auditService = auditService;
        this.audits = [];
    }
    AuditComponent.prototype.ngOnInit = function () {
        // reset login status
        this.loadAllAudits();
    };
    AuditComponent.prototype.loadAllAudits = function () {
        var _this = this;
        this.auditService.getAllAudits().subscribe(function (audits) { _this.audits = audits; });
    };
    return AuditComponent;
}());
AuditComponent = __decorate([
    core_1.Component({
        moduleId: module.id,
        templateUrl: 'audit.component.html'
    }),
    __metadata("design:paramtypes", [index_1.AuditService])
], AuditComponent);
exports.AuditComponent = AuditComponent;
//# sourceMappingURL=audit.component.js.map