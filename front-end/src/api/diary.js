import { apiInstance } from "./index.js";
const api = apiInstance();

function diaryList(success, fail){
    api.get('v1/api/diary').then(success).catch(fail);
}

function diaryOne(diaryno,success, fail){
    api.get('v1/api/diary/'+diaryno).then(success).catch(fail);
}

export {diaryList,diaryOne};