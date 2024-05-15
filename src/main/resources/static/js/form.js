
//조건 확인========================
//수강 신청 선택 과목 안보이게 하는 상태

//수강 신청 선택 과목 내역에 추가
function add(id,name,professor,classroom,subjectType,credit,dayOfWeek,startTime,endTime,maxStudent,totalStudent, event){
    let result = '';
    const table = document.getElementById('lecture');
    const addLecture = document.getElementById('addLecture');
    const new_row = addLecture.insertRow();
    const cell_length = table.rows[1].cells.length;
    //해당 과목이 체크 되어 있을 때
//    if(event.target.checked){
       //해당 과목 > 수강신청내역 table에 추가
       for(let i = 0; i < cell_length; i++) {
               const new_cell = new_row.insertCell(i);
               let temp_html = ``;
               if(i === 0) {
                       temp_html = `<tb>`+ id + `</td>`;
               } else if(i === 1) {
                        temp_html = `<td>`+ professor + `</td>`;
               } else if(i === 2) {
                       temp_html = `<td>`+ professor + `</td>`;
               } else if(i === 3) {
                        temp_html = `<td>`+ classroom + `</td>`;
               } else if(i === 4) {
                        temp_html = `<td>`+ subjectType + `</td>`;
               } else if(i === 5) {
                        temp_html = `<td>`+ credit + `</td>`;
               } else if(i === 6) {
                        temp_html = `<td>`+ dayOfWeek + `</td>`;
               } else if(i === 7) {
                         temp_html = `<td>`+ startTime + `</td>`;
               } else if(i === 8) {
                         temp_html = `<td>`+ endTime + `</td>`;
               } else if(i === 9) {
                          temp_html = `<td>`+ maxStudent + `</td>`;
               } else if(i === 10) {
                          temp_html = ` <td>`+ ( Number(totalStudent) +1 )+ `</td>`;
               } else {
                         temp_html = `<td><button onClick={handleRegister} class="btn btn-outline-primary me-2">취소</button></td>`;
               };
//                alert(temp_html);
               new_cell.insertAdjacentHTML('beforeend', temp_html);

               //수강 과목 table 정원 > + 변경
//                 alert(event.target.totalStudent);
        }
//
//    }else{
//    //해당 과목이 체크 해제 되어 있을 때
//    result = '';
//    //수강 과목 정원 > 변경
//    const new_totalStudent = Number(totalStudent)+1;
//    alert(new_totalStudent);
//
//    //alert("삭제");
//    //수강신청내역 해당 과목 삭제
//    }

     //수강 신청 선택 버튼 > 신청완료 text로 변경
//    document.getElementById('add_lecture').innerText="신청완료";
}

//checkBox 선택 신청 과목 내역
function applicationSelectedSubjects() {
    if (confirm('수강 신청을 완료하시겠습니까?')) {
        var form = document.getElementById("applicationForm");
        var selectedItems = form.querySelectorAll('input[name="checkedIds"]:checked');
        var selectedIds = [];
        for (var i = 0; i < selectedItems.length; i++) {
            selectedIds.push(selectedItems[i].value);
        }
        if(selectedIds.length === 0) {
            alert("수강 신청 내역이 없습니다.")
            return false;
        }
         alert(selectedIds);
        console.log("SelectedIDs:", selectedIds);
        form.submit();
        return true;
    } else {
        return false;}
    }

