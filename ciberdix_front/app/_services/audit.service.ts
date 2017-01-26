/**
 * Created by vladeye on 17/01/17.
 */
import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions, Response } from '@angular/http';

@Injectable()
export class AuditService {
    constructor(private http: Http) { }

    getAllAudits() {
        return this.http.get('http://localhost:8443/auditoria/').map((response: Response) => response.json());
    }

    private jwt() {
        // create authorization header with jwt tokeno


        let headers = new Headers({ 'Access-Control-Allow-Origin': '*'});

        return new RequestOptions({ headers: headers });
    }


}
