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
/**
 * Created by vladeye on 17/01/17.
 */
var core_1 = require("@angular/core");
var http_1 = require("@angular/http");
var AuditService = (function () {
    function AuditService(http) {
        this.http = http;
    }
    AuditService.prototype.getAllAudits = function () {
        return this.http.get('http://localhost:8443/auditoria/').map(function (response) { return response.json(); });
    };
    AuditService.prototype.jwt = function () {
        // create authorization header with jwt tokeno
        var headers = new http_1.Headers({ 'Access-Control-Allow-Origin': '*' });
        return new http_1.RequestOptions({ headers: headers });
    };
    return AuditService;
}());
AuditService = __decorate([
    core_1.Injectable(),
    __metadata("design:paramtypes", [http_1.Http])
], AuditService);
exports.AuditService = AuditService;
//# sourceMappingURL=audit.service.js.map