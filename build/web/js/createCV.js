firebase.initializeApp({
  apiKey: "AIzaSyAZ6arTyYxIaujt9ms2Qj4RRY4CKZDzyLY",
  authDomain: "test-4fcbb.firebaseapp.com",
  projectId: "test-4fcbb",
  storageBucket: "test-4fcbb.appspot.com",
  messagingSenderId: "347563734164",
  appId: "1:347563734164:web:1da63c52357ae4f5c5f081",
  measurementId: "G-QKVRW8LF6Q",
});
const uploadBtn = document.querySelector("#upload-btn");
const uploadInput = document.querySelector("#upload-input");
const avtDisplay = document.querySelector(".avt-display");
const hiddenInput = document.querySelector("#hidden-avt-input");
const createForm = document.querySelector("#create-form");
let fileList = [];

uploadBtn.addEventListener("click", () => {
  uploadInput.click();
});

uploadInput.addEventListener("change", (e) => {
  // e.preventDefault();
  fileList = e.target.files;
  reader = new FileReader();
  reader.addEventListener("load", () => {
    avtDisplay.src = reader.result;
  });
  reader.readAsDataURL(fileList[0]);
});

const uploadImageToFB = async () => {
  let filePath = null;
  filePath = "CV-manager/";
  const ref = firebase.storage().ref(filePath);
  const file = uploadInput.files[0];
  console.log(file);
  try {
    if (file != null) {
      console.log("inside if");
      const name = file.name;
      const metadata = {
        contentType: file.type,
      };
      const snapshot = await ref.child(name).put(file, metadata);
      let url = await snapshot.ref.getDownloadURL();
      console.log(url);
      hiddenInput.value = url;

      console.log("upload successfully " + hiddenInput.value);
    } else {
      return;
    }
  } catch (e) {
    console.log(e);
  }
};

createForm.addEventListener("submit", async (e) => {
  e.preventDefault();
  await uploadImageToFB();
  createForm.submit();
});
